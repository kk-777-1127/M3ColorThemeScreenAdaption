package io.kk__777.common

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test


class BitmapCoordinatorTest {
    @Before
    fun setup() {
        // BitmapとBitmapFactoryのモックを設定
        mockkStatic(BitmapFactory::class)
        mockkStatic(Bitmap::class)
    }

    @After
    fun tearDown() {
        // モックをクリア
        unmockkAll()
    }

    @Test
    fun `getPixelsFromImage correctly scales image to 128x128 and returns pixels array`() {
        val imageArray = ByteArray(1024)
        val originalBitmap = mockk<Bitmap>()
        val scaledBitmap = mockk<Bitmap>()

        every { BitmapFactory.decodeByteArray(imageArray, 0, imageArray.size) } returns originalBitmap
        every { Bitmap.createScaledBitmap(originalBitmap, 128, 128, true) } returns scaledBitmap
        every { scaledBitmap.width } returns 128
        every { scaledBitmap.height } returns 128
        every { scaledBitmap.getPixels(any(), 0, 128, 0, 0, 128, 128) } answers {
            val pixels = firstArg<IntArray>()
            for (i in pixels.indices) {
                pixels[i] = i
            }
        }

        val coordinator = BitmapCoordinatorForMCU()
        val result = coordinator.getPixelsFromImage(imageArray)

        assertEquals(128 * 128, result.size)
        for (i in result.indices) {
            assertEquals(i, result[i])
        }
    }

}