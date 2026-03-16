package utils;

import pages.*;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AboutPage aboutPage;
    public static AddHouseholdMemberModal addHouseholdMemberModal;
    public static DeleteModalPage deleteModalPage;

    public static void initializerPageObjects(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        aboutPage = new AboutPage();
        addHouseholdMemberModal = new AddHouseholdMemberModal();
        deleteModalPage = new DeleteModalPage();
    }
}
