package com.example.pianotiles

import android.net.Uri
import android.os.AsyncTask
import android.widget.Toast
import org.json.JSONObject
import java.io.BufferedInputStream
import java.net.URL
import java.nio.charset.Charset
import javax.net.ssl.HttpsURLConnection

class HeadlinesDownloader(val activity: GameOver) : AsyncTask<URL, Void, List<Headline>>() {

    val KEY = "e7e05678509248ceb66524f05ad67670"
    val parameters = mapOf("sources" to "bbc-news", "apiKey" to KEY)
    val url = parameterizeUrl("https://newsapi.org/v2/top-headlines", parameters)
    fun parameterizeUrl(url: String, parameters: Map<String, String>): URL {
        val builder = Uri.parse(url).buildUpon()
        parameters.forEach { key, value -> builder.appendQueryParameter(key, value) }
        val uri = builder.build()
        return URL(uri.toString())
    }

    fun getJson(url: URL): JSONObject {
        val connection = url.openConnection() as HttpsURLConnection
        try {
            val json = BufferedInputStream(connection.inputStream).readBytes().toString(Charset.defaultCharset())
            return JSONObject(json)
        } finally {
            connection.disconnect()
        }
    }

    override fun doInBackground(vararg urls: URL): List<Headline> {
        val result = getJson(url)

        val headlinesJson = result.getJSONArray("articles")
        var headlines = (0 until headlinesJson.length()).map { i ->
            val headline = headlinesJson.getJSONObject(i)
            Headline(headline.getString("title"))
        }

        return headlines
    }

    override fun onPostExecute(headlines: List<Headline>) {
        super.onPostExecute(headlines)
    }


}