// eslint-disable-next-line no-unused-vars
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import {Header} from "./header/main/mainHeader.jsx";
import {Home} from "./main/home/home.jsx";
import {News} from "./main/news/news.jsx";
import {Footer} from "./footer/main/mainFooter.jsx";
import {Report} from "./main/report/report.jsx";


export default function App() {
    return (
        <div className="App">
            <Header/>
            <div id="body-content">
                <BrowserRouter>
                    <Routes>
                        <Route path="/" element={<Home />}/>
                        <Route path="/news" element={<News />}/>
                        <Route path="/reports" element={<Report />}/>
                    </Routes>
                </BrowserRouter>
            </div>
            <Footer/>
        </div>
    );
}
