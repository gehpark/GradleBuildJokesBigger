import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.free.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * Created by gracepark on 9/17/17.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_startTask_ResultIsNotNull() {
        try {
            final EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask();

            Context context = mActivityRule.getActivity().getApplicationContext();


            endpointAsyncTask.execute(context);
            String result = endpointAsyncTask.get(30, TimeUnit.SECONDS);

            Assert.assertTrue(result.length() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
