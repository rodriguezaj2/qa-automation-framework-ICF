package utils;

import pages.AboutPage;
import pages.AddHouseholdMemberModal;
import pages.DashboardPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AboutPage aboutPage;
    public static AddHouseholdMemberModal addHouseholdMemberModal;

    public static void initializerPageObjects(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        aboutPage = new AboutPage();
        addHouseholdMemberModal = new AddHouseholdMemberModal();
    }
}
