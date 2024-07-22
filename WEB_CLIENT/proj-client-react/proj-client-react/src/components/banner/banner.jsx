// eslint-disable-next-line no-unused-vars
import React from "react";
import "./banner.style.css";

export const Banner = () => {
    return (
        <div className="position-relative overflow-hidden align-content-center text-center banner">
            <section className="cover text-center">
                <div className="container align-content-center">
                    <h1 className="font-weight-normal banner-title">Tugão News</h1>
                </div>
            </section>
        </div>
    );
};

export default Banner;