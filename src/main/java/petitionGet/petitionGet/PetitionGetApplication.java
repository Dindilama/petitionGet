package petitionGet.petitionGet;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PetitionGetApplication {

	public static class Main {
		public static void main(String[] args) {
			String apiUrl = "https://serpapi.com/integrations/java";

			try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
				HttpGet request = new HttpGet(apiUrl);
				HttpResponse response = httpClient.execute(request);
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					String responseBody = EntityUtils.toString(entity);
					System.out.println(responseBody);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	;}
}





