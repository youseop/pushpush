import React from 'react'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import LoginPage from '../LoginPage/LoginPage'

function LandingPage() {
    const user = useSelector(state => state.user)

    const playGame = () => {
        alert('게임 입장.')
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
            <div>
                <Link to='/rank'>
                    랭킹 보기
                </Link>
                <div onClick={playGame}>
                    게임 플레이 하기
                </div>
            </div>
        )
    }
}

export default LandingPage
