package com.example.apmvc.passwordchecker.service;

/**
 * @author Christian Sarnataro
 *         Created on 08/08/16.
 */
public class PasswordCheckerService {

    /**
     * Simple algorithm to calculate password strength.
     *
     * see varun's answer on stackoverflow: http://stackoverflow.com/a/7285380, slightly modified
     *
     * @param passwd
     * @return a value from 0 (for very week passwords) to 100 (very strong passwords)
     */
    public float getStrength(String passwd) {
        /* intScore can range from 0 (very week) to 37 (very strong) */
        int intScore = 0;

        if (passwd.length() > 8) {
            intScore = (intScore + 2);
        }
        if (passwd.length() > 11) {
            intScore = (intScore + 3);
        }
        if (passwd.matches("^.*[a-z].*$")) {
            intScore = (intScore + 1);
        }
        if (passwd.matches("^.*[A-Z].*$")) {
            intScore = (intScore + 5);
        }
        if (passwd.matches("^.*\\d+.*$")) {
            intScore = (intScore + 5);
        }
        if (passwd.matches("^.*(\\d.*\\d).*$")) {
            intScore = (intScore + 5);
        }
        if (passwd.matches("^.*[!,@#$%^&*?_~].*$")) {
            intScore = (intScore + 5);
        }
        if (passwd.matches("^.*([!,@#$%^&*?_~].*[!,@#$%^&*?_~]).*$")) {
            intScore = (intScore + 5);
        }
        if (passwd.matches("^.*[a-z].*$") && passwd.matches("^.*[A-Z].*$")) {
            intScore = (intScore + 2);
        }
        if (passwd.matches("^.*\\d.*$") && passwd.matches("^.*\\D.*$")) {
            intScore = (intScore + 2);
        }
        if (passwd.matches("^.*[a-z].*$") && passwd.matches("^.*[A-Z].*$") && passwd.matches("^.*\\d.*$") && passwd.matches("^.*[!,@#$%^&*?_~].*$")) {
            intScore = (intScore + 2);
        }
        return intScore / 37f  * 100;
    }
}
