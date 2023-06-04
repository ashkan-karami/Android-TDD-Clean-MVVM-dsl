package com.ashkan.userprofile.common.core.validationTest

import com.ashkan.userprofile.common.core.validation.isAValidPassport
import com.ashkan.userprofile.common.core.validation.isAValidPhoneNumber
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class UserInformationUnitTest {

    /**
     *  Test passport validation with correct data.
     */
    @Test
    fun `passport is correct`(){
        val pass = "P51659797"
        assertTrue(pass.isAValidPassport())
    }

    /**
     *  Test passport validation with incorrect data.
     */
    @Test
    fun `passport is not correct`(){
        val pass = "A12345@"
        assertFalse(pass.isAValidPassport())
    }

    /**
     *  Test phone number validation with correct data.
     */
    @Test
    fun `phone-number is correct`(){
        val phone = "+1456646545"
        assertTrue(phone.isAValidPhoneNumber())
    }

    /**
     *  Test phone number validation with incorrect data.
     */
    @Test
    fun `phone-number is not correct`(){
        val phone = "915664345"
        assertFalse(phone.isAValidPhoneNumber())
    }
}