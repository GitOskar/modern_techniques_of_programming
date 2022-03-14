package domain.model;

import lombok.Value;

@Value
public class Army {

    Headquarters headquarters;
    Integer number;

    public void attackBacks() {
        System.out.println("We are army " + (number+1) + ". Let's attack backs!");
    }

    public void sendInformationAboutWeAreAttackingLeftFlank(int armyNumber) {
        System.out.println("We are army " + (number+1) + ". Let's send information about we are attacking left flank!");
        headquarters.sendInformationAboutArmyIsAttackingLeftFlankToAnotherArmy(this.number, armyNumber);
    }

    void bindEnemysForcesNearTheSwamps() {
        System.out.println("We are army " + (number+1) + ". Let's bind enemys forces near the swamps!");
    }

    void handleInformation(String message) {
        System.out.println("We army: " + (number+1) + " are handling message: " + message);
    }
}
