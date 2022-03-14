package domain.model;

public interface Headquarters {

    void sendInformationToArmyAboutEnemyMove(int armyNumber, String direction);
    void attackBacks(int armyNumber);
    void bindEnemysForcesNearTheSwamps(int armyNumber);
    void sendInformationAboutArmyIsAttackingLeftFlankToAnotherArmy(int armyFrom, int armyTo);
    void addArmy(Army army);
    void setIntelligence(Intelligence intelligence);
    void setCommandCenter(CommandCenter commandCenter);
}
