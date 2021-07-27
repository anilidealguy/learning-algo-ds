package asked.zoom;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlToCsv {
    public static void main(String[] args) throws SQLException, IOException {
        List<String> records = fetchDataFromDatasource();
        flushDataToCsv(records);
    }

    private static void flushDataToCsv(List<String> records) throws IOException {
        File outputFile = new File("output.csv");
        FileWriter writer = new FileWriter(outputFile);
        records.forEach(r -> {
            try {
                writer.write(r);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.flush();
    }

    private static List<String> fetchDataFromDatasource() throws SQLException{
        List<String> result = new ArrayList<>();
        String header = "name,class_name,score";
        result.add(header);

        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement(getQuery());
        ResultSet resultSet = ps.getResultSet();
        while (resultSet.next()) {
            StringBuilder sb  = new StringBuilder();
            sb.append(resultSet.getString("name"))
                    .append(",")
                    .append(resultSet.getString("class_name"))
                    .append(",")
                    .append(resultSet.getBigDecimal("score"));
            result.add(sb.toString());
        }

        return result;
    }

    private static String getQuery() {
        return "select \n" +
                "  s.name,\n" +
                "  a.class_name,\n" +
                "  a.score\n" +
                "from \n" +
                "  assesments a left join studen s\n" +
                "  on \n" +
                "    a.student_id = s.student_id\n" +
                "order by \n" +
                "  s.name";
    }
}
