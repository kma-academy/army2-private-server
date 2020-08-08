/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package army2.fight.bullet;

import army2.fight.Bullet;
import army2.fight.BulletManager;
import static army2.fight.FightManager.rd;
import army2.fight.Player;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASD
 */
public class TrexThaBoom extends Bullet {

    private short Xboss, Yboss;    
    
    public TrexThaBoom(BulletManager bullMNG, byte bullId, int satThuong, Player pl, int X, int Y, int vx, int vy, int msg, int g100, short Xboss, short Yboss) {
        super(bullMNG, bullId, satThuong, pl, X, Y, vx, vy, msg, g100);
        super.isCanCollision = false;
        this.Xboss = Xboss;
        this.Yboss = Yboss;
    }
    
    @Override
    public void nextXY() {
        try {
            //dòng này
            customXY();
        } catch (IOException ex) {
            Logger.getLogger(TrexThaBoom.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        if(super.collect)
            this.bullMNG.addBullet(new Bullet(bullMNG, (byte)3, this.satThuong, super.pl, this.Xboss-140, this.Yboss-320, 5, 0, 0, 80)); // 230 486
    }
    
     public void customXY() throws IOException {
         //Số bước nhảy
        frame++;
        //Vị trí X Y của bước nhảy hiện tại
        this.XArray.add((short)X);
        this.YArray.add((short)Y);
        
        //ngoài máp thì hủy đạn
        if((X < -200) || (X > fm.mapMNG.Width + 200) || (Y > fm.mapMNG.Height+200)) {
            collect = true;
            return;
        }
        //X Y của bước nhảy trước
        short preX = X, preY = Y;
        //Tính XY bước nhảy hiện tại
        
            
        System.out.println("Tọa độ hiên tại: "+X+" "+Y); 
        //quan trọng
        X += vx; 
        
        
        
        lastX = X;
        
        //quan trọng
        Y += vy;
        
        
        
        lastY = Y;
        //Kiểm tra va chạm với map và Player
        short[] XYVC = bullMNG.getCollisionPoint(preX, preY, X, Y, isXuyenPlayer, isXuyenMap);
       //Nếu có va chạm
        if(XYVC != null) {
            //Dừng việc tính tọa độ
            collect = true;
            //Set Tọa độ cuối cùng của viên đạn
            X = XYVC[0]; Y = XYVC[1];
            XArray.add((short)X);
            YArray.add((short)Y);
            //pow và item thì ko tính SC
            if(pl.itemUsed == -1 && !pl.isUsePow) {
                if(this.isMaxY) {
                    if(this.Y-this.maxY > 350 && this.Y - this.maxY < 450)
                        this.typeSC = 1;
                    else if(this.Y - this.maxY >= 450)
                        this.typeSC = 2;
                }
                
                //SC đạn đặc biệt Id 2 và 3 ( ko cần quan tâm)
                if((pl.gunId == 2 || pl.gunId == 3) && (Math.abs(lastX - XArray.get(0)) > 375))
                    this.typeSC = 4;
            }
            //Tạo hố sau va chạm và trừ máu 
            if(this.isCanCollision)
                fm.mapMNG.collision(X, Y, this);
            return;
        }
        
        
        // cái này để kiểm soat vx.. vy
        vxTemp  += Math.abs(ax100);
        vyTemp  += Math.abs(ay100);
        vyTemp2 += g100;
        
        
        
        if(Math.abs(vxTemp) >= 100) {
            if(ax100 > 0)
                vx+=vxTemp/100;
            else
                vx-=vxTemp/100;
            vxTemp %= 100;
        }
        if(Math.abs(vyTemp) >= 100) {
            if(ay100 > 0)
                vy+=vyTemp/100;
            else
                vy-=vyTemp/100;
            vyTemp %= 100;
        }
        
        if(Math.abs(vyTemp2) >= 100) {
            vy+=vyTemp2/100;
            vyTemp2 %= 100;
        }
        //Đan ở vị trí cao nhất
        if(vy > 0 && !isMaxY) {
            isMaxY = true;
            XmaxY = X;
            maxY = Y;
        }
        
        
        //chiu anh huong cua voi rong neu ko thi xóa
        if(this.bullMNG.hasVoiRong) {
            for(BulletManager.VoiRong vr : this.bullMNG.voiRongs) {
                if(this.X >= vr.X-5 && this.X <= vr.X+10) {
                    this.vx-=2;
                    this.vy-=2;
                    break;
                }
            }
        }
        
        if (isMaxY&&X==XmaxY)
        {
             Player pl = this.fm.getPlayerClosest(this.X, this.Y);
        for (int i = 0 ; i < 21; i++)
                
            {
                vxTemp=0;
                  vx=0;
                  X = (short)(X - Math.abs(pl.X-XmaxY)/20);
                  Y = (short)(Y + Math.abs(pl.Y-XmaxY)/15);
                   this.XArray.add((short)X);
                    this.YArray.add((short)Y);
                  if (i==20 ){
                      this.typeSC    = 3;
                      this.isXuyenMap = true;
                       //this.XArray.add((short)(pl.X-6));
                      //this.YArray.add((short)Y);
					                         this.XArray.add((short)(Math.abs(pl.X-X)));
                       //this.XArray.add((short)(pl.X+i));
                      this.YArray.add((short)(pl.Y-pl.height*2-Y));
					  
					                      this.fm.TRexSaid(pl);

                      break;}
                  
            
            }
        }
        
    }

    

}