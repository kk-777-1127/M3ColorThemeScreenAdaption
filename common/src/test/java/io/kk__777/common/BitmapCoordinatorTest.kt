package io.kk__777.common

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO

class BitmapCoordinatorTest {

    private lateinit var image: BufferedImage

    @Before
    fun setup() {
        mockkStatic(ImageIO::class)
        image = mockk(relaxed = true)

        every { ImageIO.read(any<ByteArrayInputStream>()) } returns image
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `getPixelsFromImage correctly scales large image and returns pixels array`() {
        // 仮想の大きい画像データ
        val largeImageArray = ByteArray(1024 * 1024) // 1MBのダミーデータ
        every { image.width } returns 1024
        every { image.height } returns 1024

        val coordinator = BitmapCoordinatorForMCU()
        val result = coordinator.getPixelsFromImage(largeImageArray)

        // 期待される結果は、リサイズ後の128x128画像のピクセルデータ
        assertEquals(128 * 128, result.size)
    }

    @Test
    fun `getPixelsFromImage correctly handles small image and returns pixels array`() {
        // 仮想の小さい画像データ
        val smallImageArray = ByteArray(64 * 64) // 4KBのダミーデータ
        every { image.width } returns 64
        every { image.height } returns 64

        val coordinator = BitmapCoordinatorForMCU()
        val result = coordinator.getPixelsFromImage(smallImageArray)

        // 期待される結果は、リサイズせずにそのままの64x64画像のピクセルデータ
        // この関数では必ず128x128にリサイズするので、テスト結果の期待値も128x128のサイズになります。
        assertEquals(128 * 128, result.size)
    }
}