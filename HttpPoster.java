import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;

public class HttpPoster {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        File file = new File("1.json");
        HttpPost post = new HttpPost("http://localhost:9200/accounts/person/1");
        EntityBuilder builder = EntityBuilder.create();
        builder.setFile(file);
        builder.setContentType(ContentType.DEFAULT_TEXT);
        HttpEntity entity = builder.build();
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine());
        client.close();
    }
}
