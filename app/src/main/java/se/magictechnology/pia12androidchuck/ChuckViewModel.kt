package se.magictechnology.pia12androidchuck

import android.util.Log
import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException

class ChuckViewModel : ViewModel() {

    private val _currentjoke = MutableStateFlow<Chuckjoke?>(null)
    val currentjoke : StateFlow<Chuckjoke?> get() = _currentjoke

    private val _categories = MutableStateFlow<List<String>?>(null)
    val categories : StateFlow<List<String>?> get() = _categories


    private val client = OkHttpClient()


    fun randomjoke() {
        val request = Request.Builder()
            .url("https://api.chucknorris.io/jokes/random")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responsetext = response.body!!.string()
                    Log.i("PIA12DEBUG", responsetext)

                    /*
                    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                    val jsonAdapter : JsonAdapter<Chuckjoke> = moshi.adapter<Chuckjoke>()
                    val thejoke = jsonAdapter.fromJson(responsetext)
                    */
                    val thejoke = Json { ignoreUnknownKeys = true }.decodeFromString<Chuckjoke>(responsetext)

                    _currentjoke.value = thejoke
                }
            }
        })

    }

    fun loadcategories() {
        val request = Request.Builder()
            .url("https://api.chucknorris.io/jokes/categories")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responsetext = response.body!!.string()
                    Log.i("PIA12DEBUG", responsetext)

                    val cats = Json { ignoreUnknownKeys = true }.decodeFromString<List<String>>(responsetext)

                    _categories.value = cats
                }
            }
        })

    }

    fun categoryjoke(category : String) {

    }





    private val _thenumber = MutableStateFlow<Int>(0)
    val thenumber : StateFlow<Int> get() = _thenumber

    fun numberPlus() {
        _thenumber.value = _thenumber.value + 1
    }

}

@Serializable
data class Chuckjoke(val created_at : String, val value : String)
