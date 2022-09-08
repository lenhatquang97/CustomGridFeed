package com.quangln2.customgrid

import android.app.Activity
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.media.ThumbnailUtils
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var thumbnail: ImageView
    private lateinit var customGridGroup: CustomGridGroup
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.videoView)
        //play raw video
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.bunny)
        videoView.start()

        customGridGroup = findViewById(R.id.customGridGroup)
        thumbnail = findViewById(R.id.thumbnail)
        button = findViewById(R.id.button)
    }
}