import Axios from 'axios'
import React from 'react'
import { useConstructor } from '../../functions/useConstructor'

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
  })

  console.log(personalRank, majorRank);

  return (
    <div>
      RankPage
    </div>
  )
}

export default RankPage
