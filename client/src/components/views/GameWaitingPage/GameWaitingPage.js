import React from 'react'
import { connectSocket } from '../../functions/socket';
import './GameWaitingPage.css'

function GameWaitingPage(props) {
  const roomId = props.match.params.roomId;

  return (
    <div>
      GameWaitingPage 
      <h1>웹 소켓을 사용한 채팅방입니다.</h1>
      <div id="chatConnect">
        <button onClick={()=>connectSocket(roomId)}>채팅 시작하기</button>
      </div>
      {`roomnumber ${roomId}`}
    </div>
  )
}

export default GameWaitingPage
