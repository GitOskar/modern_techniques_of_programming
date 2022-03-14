package domain.model;

public class Presentation {

    public static void main(String[] args) {

        Headquarters headquarters = new HeadquartersImpl();
        Army firstArmy = new Army(headquarters, 0);
        Army secondArmy = new Army(headquarters, 1);
        CommandCenter commandCenter = new CommandCenter(headquarters);
        Intelligence intelligence = new Intelligence(headquarters);
        headquarters.addArmy(firstArmy);
        headquarters.addArmy(secondArmy);
        headquarters.setCommandCenter(commandCenter);
        headquarters.setIntelligence(intelligence);

        System.out.println("=========== First activity ===========");
        intelligence.sendInformationToArmyAboutEnemyMove(0, "EAST");

        System.out.println("=========== Second activity ===========");
        firstArmy.sendInformationAboutWeAreAttackingLeftFlank(1);

        System.out.println("=========== Third activity ===========");
        commandCenter.attackBacksWithSecondArmy();

        System.out.println("=========== Fourth activity ===========");
        commandCenter.bindEnemysForcesNearTheSwamps(0);
    }
}
