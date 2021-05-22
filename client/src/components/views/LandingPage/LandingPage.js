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
    if (false) {
        return (
            <Link to='/login'>
                로그인
            </Link>
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
                    className="landing blue_btn"
                >
                    게임 플레이 하기
                </div>
                <Link 
                    to='/rank' 
                    className="landing blue_btn"
                >
                    랭킹 보기
                </Link>
            </div>
        )
    }
}

export default LandingPage
