import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScholarAuthorModel {
    private String authorId;
    private String authorName;

    public ScholarAuthorModel(String authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void fetchData() {
        try {
            String url = "https://api.scholar.google.com/v1/citations?user=" + authorId;

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Aquí deberías procesar o utilizar la respuesta según tus necesidades
            // Por ejemplo, imprimir la respuesta:
            System.out.println("Response: " + response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScholarAuthorModel author = new ScholarAuthorModel("YOUR_AUTHOR_ID", "Author Name");
        author.fetchData();
    }
}

