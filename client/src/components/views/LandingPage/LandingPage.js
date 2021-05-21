import React from 'react'
import { useSelector } from 'react-redux'
import { Link } from 'react-router-dom'
import LoginPage from '../LoginPage/LoginPage'

function LandingPage() {
    const user = useSelector(state => state.user)

    if (!user?.userData?.isAuth) {
        return (
            <Link to='/login'>
                로그인
            </Link>
        )
    }
    else {
        return (
            <div>
                game play
            </div>
        )
    }
}

export default LandingPage
