import React from 'react'
import './RankCard.css'

function RankCard({info, index}) {
  return (
    <div className="rankcard_container">
      <div className="rankcard_left">
        <div className="rankcard_index">
          <div className="number">
            {index}
          </div>
        </div>
        <div>{info.major}</div>
      </div>
      <div className="rankcard_score">{info.score} wins</div>
    </div>
  )
}

export default RankCard
