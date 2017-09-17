import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * Created by gracepark on 9/17/17.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    @Test
    public void test_startTask_ResultIsNotNull() {
        try {
            final EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask();

            new Runnable() {
                public void run() {
                    endpointAsyncTask.execute(new MainActivity());
                }
            };
            String result = endpointAsyncTask.get(30, TimeUnit.SECONDS);

            Assert.assertTrue(result.length() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
