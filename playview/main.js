import Phaser from 'phaser'
import Game from './src/Game'

const config = {
    width: window.innerWidth,
    height: window.innerHeight,
    type: Phaser.AUTO,
    backgroundColor: '#616161', 
    physics: {
        default: 'arcade',
        arcade: {
            gravity: { y: 0 },
            //debug: true
        }
    }
}

const game = new Phaser.Game(config)

game.scene.add('game', Game)

//game.scene.start('titlescreen')
game.scene.start('game')
