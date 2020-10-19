import com.example.controllers.ProfileController
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ProfileControllerTest {
    private val profileController = ProfileController()

    @Test
    fun getUserInfoFromDatabase() {
        println(profileController.getUserInfoFromDatabase())
    }
}