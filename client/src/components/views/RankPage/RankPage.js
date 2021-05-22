import Axios from 'axios'
import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { useConstructor } from '../../functions/useConstructor'
import RankCard from './RankCard'
import './RankPage.css'

function RankPage() {
  const [personalRank, setPersonalRank] = useState([]);
  const [majorRank, setMajorRank] = useState([]);

  useConstructor(async () => {
    Axios.get('api/rank/').then((response)=>{
      if (response.data) {
        setMajorRank(response.data);
      }
    })
  })

  const rankCards = majorRank.map((info, index) => {
    return(
      <RankCard 
        key={info.major_idx}
        info={info}
        index={index+1}
      />
    )
  })

  return (
    <div className="rank">
      <div className="filter"></div>
      <div className="rank_container">
        <img 
          className="rank_title"
          src="https://i.imgur.com/HhkSr9M.png" 
          title="ranking" 
        />
        {rankCards}
        <Link 
            to='/' 
            className="rankPage_back"
        >
            <svg width="53" height="38" viewBox="0 0 53 38" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M40 12.3571L26.5 25.6428M26.5 12.3571L40 25.6428M46.75 1.28571H17.5L1.75 19L17.5 36.7143H46.75C47.9435 36.7143 49.0881 36.2477 49.932 35.4172C50.7759 34.5867 51.25 33.4602 51.25 32.2857V5.71428C51.25 4.53975 50.7759 3.41332 49.932 2.5828C49.0881 1.75229 47.9435 1.28571 46.75 1.28571Z" stroke="#F8F0FB" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/>
            </svg>
        </Link>
      </div>
    </div>
  )
}

export default RankPage
