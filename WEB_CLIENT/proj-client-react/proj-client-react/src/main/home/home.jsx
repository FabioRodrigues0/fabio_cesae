// eslint-disable-next-line no-unused-vars
import React from "react";
import "./home.style.css";
import {Banner} from "../../components/banner/banner.jsx";
import {About} from "../../components/about/about.jsx";

export const Home = () => {
    return (
        <div className="page-home">
            <Banner />
            <About />
        </div>
    );
};