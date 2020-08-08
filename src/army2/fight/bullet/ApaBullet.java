package army2.fight.bullet;

import army2.fight.Bullet;
import army2.fight.BulletManager;
import army2.fight.FightManager;
import army2.fight.MapManager;
import army2.fight.Player;
import army2.server.Until;

public class ApaBullet
  extends Bullet
{
  protected byte force;
  protected byte force2;
  
  public ApaBullet(BulletManager bullMNG, byte bullId, int satThuong, Player pl, int X, int Y, int vx, int vy, int msg, int g100, byte force, byte force2)
  {
    super(bullMNG, bullId, satThuong, pl, X, Y, vx, vy, msg, g100);
    this.force = force;
    this.force2 = force2;
  }
  
  public void nextXY()
  {
    super.nextXY();
    if (force2 == frame + 1) {
      fm.mapMNG.collision(X, Y, this);
      int arg = bullMNG.arg;
      int x = lastX + (20 * Until.cos(arg) >> 10);
      int y = lastY - 12 - (20 * Until.sin(arg) >> 10);
      if (bullMNG.arg < 0)
      {
        for (int i = 0; i < 3; arg += 50) {
          int vxn = force / 2 * Until.cos(bullMNG.arg) >> 10;
          int vyn = force / 2 * Until.sin(arg) >> 10;
          bullMNG.addBullet(new Bullet(bullMNG, (byte)18, satThuong, pl, x, y, vxn, vyn, 30, 100));i++;
        }
        
      }
      else if ((bullMNG.arg >= 0) && (bullMNG.arg < 90))
      {
        for (int i = 0; i < 3; arg -= 50) {
          int vxn = force / 2 * Until.cos(0) >> 10;
          int vyn = -(force / 2 * Until.sin(arg) >> 10);
          bullMNG.addBullet(new Bullet(bullMNG, (byte)18, satThuong, pl, x, y, vxn, vyn, 30, 100));i++;
        }
        
      }
      else if ((bullMNG.arg > 90) && (bullMNG.arg <= 180))
      {
        for (int i = 0; i < 3; arg += 50) {
          int vxn = force / 2 * Until.cos(180) >> 10;
          int vyn = -(force / 2 * Until.sin(arg) >> 10);
          bullMNG.addBullet(new Bullet(bullMNG, (byte)18, satThuong, pl, x, y, vxn, vyn, 30, 100));i++;
        }
        
      }
      else if ((bullMNG.arg > 180) && (bullMNG.arg <= 225))
      {
        for (int i = 0; i < 3; arg -= 50) {
          int vxn = force / 2 * Until.cos(bullMNG.arg) >> 10;
          int vyn = force / 2 * Until.sin(arg) >> 10;
          bullMNG.addBullet(new Bullet(bullMNG, (byte)18, satThuong, pl, x, y, vxn, vyn, 30, 100));i++;
        }
      }
    }
  }
}
