/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package army2.fight.boss;

import army2.fight.Player;
import army2.fight.Boss;
import army2.fight.Bullet;
import army2.fight.FightManager;
import java.io.IOException;

/**
 *
 * @author ASD
 */
public class KVCam extends Boss {
    
    public boolean isExists;

    public KVCam(FightManager fightMNG, byte idGun, String name, byte location, int HPMax, short X, short Y) throws IOException {
        super(fightMNG, idGun, name, location, HPMax, X, Y);
        super.theLuc = 0;
        super.width     = 52;
        super.height    = 45;
        this.isExists = true;
    }

    @Override
    public boolean isCollision(short X, short Y) {
        if(this.isExists)
            return super.isCollision(X, Y);
        return true;
    }

    @Override
    public void collision(short bx, short by, Bullet bull) {
        if(!this.isExists)
            return;
        super.collision(bx, by, bull);
    }

    public void rexAction() {
        this.isDie = false;
        this.isExists = true;
    }
    
    @Override
    public void turnAction() {
        Player pl = this.fightMNG.getPlayerClosest(this.X, this.Y);
        while(X != pl.X || Y != pl.Y) {
            int preX = this.X;
            int preY = this.Y;
            if(pl.X < this.X)
                super.move(true);
            else if(pl.X > this.X)
                super.move(true);
            else if(!fightMNG.mapMNG.isCollision(this.X, this.Y))
                this.Y++;
            // if ko di chuyen dc
            if(preX == this.X && preY == this.Y)
                break;
        }
        try {
            this.fightMNG.changeLocation(super.index);
            if(Math.abs(X - pl.X) >= 30)
                this.fightMNG.newShootBoss(this.index, (byte)4, (short)105, (byte)30, (byte)0, (byte)1, false, pl.X, this.Y);
            else
                this.fightMNG.nextTurn();
            //this.fightMNG.nextTurn();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
