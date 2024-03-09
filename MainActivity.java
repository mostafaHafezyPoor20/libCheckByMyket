package mostafa.hafezypoor.phpstorm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG001402", get());
    }
    private String get(){
        try {

            // Executes the command.

         //   Process process = Runtime.getRuntime().exec("/system/bin/rm javaorg  /sdcard");
           Process process = Runtime.getRuntime().exec("shell reboot");


            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            // Waits for the command to finish.
            process.waitFor();

            return output.toString();
        } catch (IOException e) {
            Log.i("TAG001402", e.getMessage());
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            Log.i("TAG001402", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}