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
import static army2.server.User.rd;
import java.io.DataOutputStream;
import java.io.IOException;
import network.Message;

/**
 *
 * @author ASD
 */
public class TRex extends Boss {
    
    public boolean isExists;

    public TRex(FightManager fightMNG, byte idGun, String name, byte location, int HPMax, short X, short Y) throws IOException {
        super(fightMNG, idGun, name, location, HPMax, X, Y);
        super.theLuc    = 100;
        super.width     = 30; //49
        super.height    = 28; //52
        this.isExists   = true;
    }

    @Override
    public boolean isCollision(short X, short Y) {
        if(this.isExists)
            return super.isCollision(X, Y);
        return false;
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
        /*while(X != pl.X || Y != pl.Y) {
            int preX = this.X;
            int preY = this.Y;
            if(pl.X < this.X)
                super.move(false);
            else if(pl.X > this.X)
                super.move(true);
            else if(!fightMNG.mapMNG.isCollision(this.X, this.Y))
                this.Y++;
            // if ko di chuyen dc
            if(preX == this.X && preY == this.Y)
                break;
        }*/
        try {
            //this.fightMNG.changeLocation(super.index);
            int i = rd.nextInt(2);
            if(Math.abs(X - pl.X) <= 150)
                /*this.fightMNG.newShoot(this.index, (byte)35, (short)0, (byte)0, (byte)0, (byte)1, false);*/
                this.fightMNG.newShootBoss(this.index, (byte)1, (short)135, (byte)30, (byte)0, (byte)1, false, pl.X, this.Y);

            else
                //this.fightMNG.newShoot(index, (byte)35,  (byte)90, (byte)30, (byte)0, (byte)1,false);
                if(i == 0) this.fightMNG.newShootBoss(this.index, (byte)0, (short)105, (byte)30, (byte)0, (byte)1, false, pl.X, this.Y);
                if(i == 1) this.fightMNG.newShootBoss(this.index, (byte)2, (short)105, (byte)30, (byte)0, (byte)1, false, pl.X, this.Y);
                
        Message ms = new Message(9); DataOutputStream ds = ms.writer();
        ds.writeInt(0);
        ds.writeUTF("TRex: Hãy nhận những phát bắn của ta, địt mẹ mày!");
        ds.flush();
        super.fightMNG.sendToTeam(ms);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
