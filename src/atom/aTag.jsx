import React from 'react';

const ATag = ({link, text}) => {
    return (
        <a href={link} className='underline decoration-1'>{text}</a>
    );
};

export default ATag;