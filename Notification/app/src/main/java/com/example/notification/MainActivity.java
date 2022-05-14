package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void display_notification(View view) {

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.icon_app);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Notification Title")
                .setContentText("user liked your photo")
                .setSmallIcon(R.drawable.icon_app)
                .setLargeIcon(bitmap)
                .setAutoCancel(true)
                .setNumber(1);

        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        builder.setVibrate(new long[]{500,1000,500,1000,500});
        builder.setSound(Uri.parse("android.resource://" + getPackageName() + "/"+ R.raw.that_was));

        nm.notify(1,builder.build());

    }
}