// eslint-disable-next-line no-unused-vars
import React from "react";
import "./report.style.css";
import {ReportForm} from '../../components/reportForm/reportForm.jsx';

export const Report = () => {

    return (
        <section id="report" className="container my-4 align-items-center rounded-3 border">
            <ReportForm />
        </section>
    );
};

export default Report;