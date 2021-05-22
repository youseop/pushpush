import React, { Suspense } from 'react';
import { Route, Switch } from "react-router-dom";
import Auth from "../hoc/auth";
import GameWaitingPage from './views/GameWaitingPage/GameWaitingPage';
// pages for this product
import LandingPage from "./views/LandingPage/LandingPage.js";
import LoginPage from "./views/LoginPage/LoginPage.js";
import RankPage from './views/RankPage/RankPage';
import RegisterPage from "./views/RegisterPage/RegisterPage.js";

//null   Anyone Can go inside
//true   only logged in user can go inside
//false  logged in user can't go inside

function App() {
  return (
    <Suspense fallback={(<div>Loading...</div>)}>
      <Switch>
        <Route exact path="/" component={Auth(LandingPage, null)} />
        <Route exact path="/login" component={Auth(LoginPage, false)} />
        <Route exact path="/register" component={Auth(RegisterPage, false)} />
        <Route exact path="/rank" component={Auth(RankPage, true)} />
        <Route exact path="/waiting-room/:roomId" component={Auth(GameWaitingPage, true)} />
      </Switch>
    </Suspense>
  );
}

export default App;
