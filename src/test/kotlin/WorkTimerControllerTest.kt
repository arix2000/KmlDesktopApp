import com.example.models.Work
import com.example.controllers.WorkTimerController
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WorkTimerControllerTest {

    private val controller = WorkTimerController()

    @Test
    fun validate() {

        singleValidateEquals(Work("Praca nad czymś konkretnym", "testowy opis", "30", "60"))
        singleValidateEquals(Work("Praca nad czymś konkretnym", "testowy opis", "0", "0"))
        singleValidateNotEquals(Work("", "yay", "12", "39"))
        singleValidateNotEquals(Work("", "yay", "0", "61"))
    }
    private fun singleValidateEquals(work: Work)
    {
        val result = controller.validate(work)
        assertEquals(WorkTimerController.VALIDATION_SUCCESSFUL, result)
    }

    private fun singleValidateNotEquals(work: Work)
    {
        val result = controller.validate(work)
        assertNotEquals(WorkTimerController.VALIDATION_SUCCESSFUL, result)
    }
}