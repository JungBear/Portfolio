import React from 'react';
import Title from '../../atom/title';
import { introduction } from './introduction';
import Contact from './Contact/contact';
import Education from './Education/education';
import Skills from './Skills/skills';

const AboutMe = () => {
    return (
        <div>
            <Title title={"👩🏻‍💻 ABOUT ME"} />
            <div className='grid grid-cols-1 gap-y-12'>
                <div className='lg:grid-cols-5 grid items-center gap-y-10 lg:max-w-7xl'>
                    <div className='lg:col-span-3'>
                        <div className='mt-8'>
                            {introduction.map((intro, idx)=>(
                                <p key={idx}>{intro}</p>
                            ))}
                        </div>
                    </div>
                    <Contact />
                </div>
                <Education />
                <Skills />
            </div>  
        </div>
    );
};

export default AboutMe;