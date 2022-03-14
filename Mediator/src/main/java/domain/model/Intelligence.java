package domain.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Intelligence {

    private final Headquarters headquarters;

    public void sendInformationToArmyAboutEnemyMove(int armyNumber, String direction) {
        System.out.println("We are intelligence! We are sending information about enemy move to " + (armyNumber+1));
        headquarters.sendInformationToArmyAboutEnemyMove(armyNumber, direction);
    }
}
