import com.voicerecorder.entity.PhraseEntity;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


class ControllerTest {



    @Test
    void test_add_Phrase_200() throws Exception {

        HttpUriRequest request = new HttpPost( "http://localhost:8080/v1/phrase" );

        PhraseEntity phraseEntity = new PhraseEntity(1L, 5L, "originalPhrase", "engTranslation", "somePath");

        String json = phraseEntity.toString();

        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        Assertions.assertEquals(200, httpResponse.getCode());

    }
}
