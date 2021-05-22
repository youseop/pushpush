import React from 'react'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import './LandingPage.css'

function LandingPage(props) {
    const user = useSelector(state => state.user)

    const roomId = 12345

    const playGame = () => {
        props.history.push(`/waiting-room/${roomId}`)
    }

    // if (!user?.userData?.isAuth) {
    if (true) {
        return (
            <div className="landing_container">
                <img 
                    className="landing_img"
                    src="https://i.imgur.com/r1248mm.png" 
                    alt=""
                />
                <Link to='/login' className="start_btn">
                    로그인
                </Link>
            </div>
        )
    }
    else {
        return (
            <div className="landing_container">
                <img 
                    className="landing_img"
                    src="https://i.imgur.com/r1248mm.png" 
                    alt=""
                />
                <div 
                    onClick={playGame} 
                    className="landing start_btn"
                >
                    Start!
                </div>
                <Link 
                    to='/rank' 
                    className="landing rank_btn"
                >
                    Ranking?
                </Link>
            </div>
        )
    }
}

export default LandingPage
