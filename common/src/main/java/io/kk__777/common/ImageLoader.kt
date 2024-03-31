package io.kk__777.common

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.request.get
import io.ktor.http.append
import io.ktor.http.headers
import kotlinx.coroutines.runBlocking
import java.net.URI

interface ImageLoader {
    fun downloadImage(uri: URI): Result<ByteArray>

    companion object {
        fun create(
            // TODO Make it possible to custom httpClient from client.
//            httpClient: HttpClient? = null
            headerMap: Map<String, String> = emptyMap()/*mapOf("Authorization" to "Client-ID CFsC_KJzVclTMw3G2SmI3aRZ5rKBLbCrHzfi2_XX6Cg") */
        ): ImageLoader {
            val httpClient: HttpClient? = null
            val client = httpClient ?: HttpClient(CIO) {
                headers {
                    headerMap.forEach {
                        append(it.key, it.value)
                    }
                }
                engine {
                    endpoint {
                        maxConnectionsPerRoute = 100
                        pipelineMaxSize = 20
                        keepAliveTime = 5000
                        connectTimeout = 5000
                        connectAttempts = 5
                    }
                }
            }
            return ImageLoaderImpl(client)
        }
    }
}

internal class ImageLoaderImpl(
    private val client: HttpClient
): ImageLoader {
    override fun downloadImage(uri: URI): Result<ByteArray> {
        return runBlocking {
            runCatching {
                client.get(uri.toURL().toString()).body()
            }
        }
    }
}