import com.example.Work
import com.example.controllers.WorkTimerController
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WorkTimerControllerTest {

    private val controller = WorkTimerController()

    @Test
    fun validate() {
        var work = Work("Praca nad czymś konkretnym", "testowy opis", "30", "60")
        var result = controller.validate(work)
        assertEquals(WorkTimerController.VALIDATION_SUCCESSFUL, result)

        work = Work("Praca nad czymś konkretnym", "testowy opis", "0", "0")
        result = controller.validate(work)
        assertEquals(WorkTimerController.VALIDATION_SUCCESSFUL, result)

        work = Work("", "yay", "0", "0")
        result = controller.validate(work)
        assertNotEquals(WorkTimerController.VALIDATION_SUCCESSFUL, result)

        work = Work("", "yay", "0", "61")
        result = controller.validate(work)
        assertNotEquals(WorkTimerController.VALIDATION_SUCCESSFUL, result)

    }
}