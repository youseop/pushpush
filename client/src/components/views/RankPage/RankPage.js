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
    // Axios.get('api/rank/').then((response)=>{
    //   if (response.data.success) {
    //     setPersonalRank(response.data.rank_personal);
    //     setMajorRank(response.data.rank_major);
    //   }
    // })
    setMajorRank([
      {
        major: "Japanese Culture & Language",
        score: 1000
      },
      {
        major: "Policitcal Science",
        score: 151
      },
      {
        major: "aaa",
        score: 121
      },
      {
        major: "bbb",
        score: 111
      },
      {
        major: "ccc",
        score: 100
      },
      {
        major: "ddd",
        score: 16
      },
      {
        major: "eee",
        score: 15
      },
      {
        major: "fff",
        score: 12
      },
      {
        major: "Business Administration",
        score: 1
      }
    ])
  })

  

  console.log(personalRank, majorRank);

  const rankCards = majorRank.map((info, index) => {
    return(
      <RankCard 
        key={info.major}
        info={info}
        index={index+1}
      />
    )
  })

  return (
    <div className="rank">
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
            뒤로가기
        </Link>
      </div>
    </div>
  )
}

export default RankPage
