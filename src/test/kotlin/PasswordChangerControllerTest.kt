import com.example.controllers.PasswordChangerController
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PasswordChangerControllerTest {

    @Test
    fun isSuite() {
        val controller = PasswordChangerController()
        assertFalse(controller.isSuite("",""))
        assertTrue(controller.isSuite("sometext", "doesn't care about what is there witten"))

    }
}