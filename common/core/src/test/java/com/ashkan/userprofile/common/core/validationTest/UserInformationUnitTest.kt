package com.ashkan.userprofile.common.core.validationTest

import com.ashkan.userprofile.common.core.validation.isAValidPassport
import junit.framework.TestCase.assertTrue
import org.junit.Test

class UserInformationUnitTest {

    @Test
    fun `passport is correct`(){
        val pass = "P51659797"
        assertTrue(pass.isAValidPassport())
    }

    @Test
    fun `passport is not correct`(){
        val pass = "A12345@"
        assertTrue(pass.isAValidPassport())
    }
}