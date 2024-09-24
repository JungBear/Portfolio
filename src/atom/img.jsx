import React from 'react';

const Img = ({src, alt, width, height}) => {
    return (
        <img
            src={src}
            alt={alt} 
            className='w-full aspect-w-1 aspect-h-1 rounded-md overflow-hidden object-cover group-hover:opacity-75 h-60 lg:aspect-none'
            width={width}   
            height={height}
            referrerPolicy="no-referrer"
        />
    );
};

export default Img;