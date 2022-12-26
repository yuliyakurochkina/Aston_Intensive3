package com.example.aston_intensive3

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.aston_intensive3.databinding.ActivityTask2PicturesBinding

class Task2PicturesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTask2PicturesBinding
    private lateinit var imageUrl: String

    companion object {
        const val KEY_IMAGE_URL = "KEY_IMAGE_URL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2PicturesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageUrl = savedInstanceState?.getString(KEY_IMAGE_URL).toString()
        customizeEditText()
    }

    private fun customizeEditText() {
        binding.editText.doAfterTextChanged { imageUrl ->
            if (imageUrl.isNullOrBlank()) {
                return@doAfterTextChanged
            }
            binding.ivRandomImage.post {
                showPicture(imageUrl = imageUrl.toString(), imageView = binding.ivRandomImage)
            }
        }
    }

    private fun showPicture(imageUrl: String, imageView: ImageView) {
        Glide.with(this@Task2PicturesActivity)
            .asBitmap()
            .load(imageUrl)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    showToast(R.string.toast_message)
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(binding.ivRandomImage)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_IMAGE_URL, imageUrl)
    }

    fun showToast(strName: Int) {
        Toast.makeText(this, getString(strName), Toast.LENGTH_SHORT).show()
    }
}