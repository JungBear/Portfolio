import React from 'react';
import Title from '../../atom/title';
import { projects } from './data';
import Subtitle from '../../atom/subtitle';
import Img from '../../atom/img';
import SubText from '../../atom/subText';
import Text from '../../atom/text';
import Tag from '../../atom/tag';

const Project = () => {
    const defaultImg = "/img/project/default.png"
    return (
        <div>
            <Title title={"🛠 PROJECT"} />
            <div className='grid grid-cols-1 gap-y-6 mt-5'>
                {projects.map((project, idx)=>(
                    <div key={idx} className='drop-shadow-sm'>
                        <Subtitle title={project.title} />
                        <div className='mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8'>
                            {project.items.map((item, idx)=>(
                                <div key={idx} className='group relative cursor-pointer '>
                                    <div className='relative w-full'>
                                        <img
                                            src={item.imgSrc? item.imgSrc : defaultImg}
                                            alt={item.name}
                                            className="w-full aspect-1 rounded-md overflow-hidden group-hover:opacity-75 lg:aspect-none "
                                            onError={(e) => {
                                            e.target.onerror = null;
                                            e.target.src = "/img/project/bg-w.png"; // 플레이스홀더 이미지 경로
                                            }}
                                        />
                                    </div>
                                        <div className='mt-4'>
                                            <SubText>{item.date}</SubText>
                                            <Text>
                                                {item.name}
                                                <a href={item.href}>
                                                    <span aria-hidden="true" className='absolute inset-0'/>
                                                </a>
                                            </Text>
                                            <div>
                                                {item.tags.map((tag, idx)=>(
                                                    <Tag key={idx}>{tag}</Tag>
                                                ))}
                                            </div>
                                        </div>
                                </div>
                            ))}
                        </div>
                    </div>
                ))}

            </div>
        </div>
    );
};

export default Project;