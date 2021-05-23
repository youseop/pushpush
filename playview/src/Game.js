import Phaser from 'phaser'
import dawn from './assets/Dawn_field1.png'
import backDawn from './assets/Dawn_back.png'
import noon from './assets/Noon_field.png'
import backNoon from './assets/Noon_back.png'
import sunset from './assets/Sunset_field.png'
import backSunset from './assets/Sunset_back.png'
import fre1 from './assets/fre1.png'
import fre5 from './assets/fre5.png'


class Game extends Phaser.Scene
{
    init()
    {
        
    }
    
    preload()
    {
        this.load.image('dawn', dawn)
        this.load.image('backDawn', backDawn)
        this.load.image('noon', noon)
        this.load.image('backNoon', backNoon)
        this.load.image('sunset', sunset)
        this.load.image('backSunset', backSunset)
        this.load.image('fre1',fre1)
        this.load.image('fre5',fre5)
    }

    create()
    {
        var rnd = Phaser.Math.RND
        var value = rnd.between(1, 3)
        console.log(value)

        if(value == 1) {
            this.backDawn = this.add.image(this.cameras.main.centerX, this.cameras.main.centerY, 'backDawn')
            this.backDawn.setDisplaySize(window.innerWidth,window.innerHeight)
            
            this.mapDawn = this.add.image(this.cameras.main.centerX, 700, 'dawn')
            this.mapDawn.setDisplaySize(2200,950)
        }
        else if(value == 2) {
            this.backNoon = this.add.image(this.cameras.main.centerX, this.cameras.main.centerY, 'backNoon')
            this.backNoon.setDisplaySize(window.innerWidth,window.innerHeight)
        
            this.mapNoon = this.add.image(this.cameras.main.centerX, 700, 'noon')
            this.mapNoon.setDisplaySize(2200,950)
        }
        else{
            this.backSunset = this.add.image(this.cameras.main.centerX, this.cameras.main.centerY, 'backSunset')
            this.backSunset.setDisplaySize(window.innerWidth,window.innerHeight)
            
            this.mapSunset = this.add.image(this.cameras.main.centerX, 700, 'sunset')
            this.mapSunset.setDisplaySize(2200,950)
        }

        this.rec = this.add.rectangle(this.cameras.main.centerX, 530, window.innerWidth-400,window.innerHeight-400,0xffffff)
        this.rec.setFillStyle()
        this.rec.setStrokeStyle(5, 0xffffff, 0)
        this.physics.add.existing(this.rec, true)
        
        this.ball1 = this.add.image(500,500,'fre1')
        this.ball1.setDisplaySize(80,80)
        this.physics.add.existing(this.ball1)
        this.ball1.body.setBounce(1,1)

        this.ball1.body.setCollideWorldBounds(true, 1, 1)

        this.ball2 = this.add.image(900,500,'fre1')
        this.ball2.setDisplaySize(80,80)
        this.physics.add.existing(this.ball2)

        this.ball2.body.setBounce(1,1)
        this.ball2.body.setMass(100)
        //this.ball1.body.setCircle(50)

        this.ball2.body.setCollideWorldBounds(true, 1, 1)

        this.cursors = this.input.keyboard.createCursorKeys()
    }

    update()
    {
        this.physics.add.collider(this.rec, this.ball1)
        this.physics.add.collider(this.rec, this.ball2)
        this.physics.add.collider(this.ball1, this.ball2)


         /**@type {Phaser.Physics.Arcade.StaticBody} */
        const body = this.ball1.body

        body.setVelocity(0);

        if(this.cursors.up.isDown)
        {
            body.setVelocityY(-300)
            //body.updateFromGameObject() //physics box랑 같이 움직이도록
            
        }
        else if (this.cursors.down.isDown)
        {
            body.setVelocityY(300)
            //body.updateFromGameObject()
        }
        else if (this.cursors.left.isDown)
        {
            body.setVelocityX(-300)
            //body.updateFromGameObject()
        }
        else if (this.cursors.right.isDown)
        {
            body.setVelocityX(300)
            //body.updateFromGameObject()
        }

      var flag = true; 

        if (this.ball1.x < 200 || this.ball1.x > window.innerWidth-200 || this.ball1.y < 200 || this.ball1.y > window.innerHeight-200)  
        {
            flag = false;
            this.ball1.setTexture('fre5');
            //this.ball1.setFillStyle(0xffffff, 1)
            

        }

        if (this.ball2.x < 200 || this.ball2.x > window.innerWidth-200 || this.ball2.y < 200 || this.ball2.y > window.innerHeight-200)  
        {
            flag = false;
            //this.ball2.setFillStyle(0xffffff, 1)
        }

        
       
    }
}

export default Game